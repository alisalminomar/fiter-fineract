/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.accounting.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.accounting.glaccount.data.GLAccountData;
import org.apache.fineract.accounting.glaccount.domain.GLAccountType;
import org.apache.fineract.accounting.glaccount.domain.GLAccountUsage;
import org.apache.fineract.accounting.glaccount.service.GLAccountReadPlatformService;
import org.apache.fineract.accounting.journalentry.domain.JournalEntryType;
import org.apache.fineract.infrastructure.core.data.EnumOptionData;
import org.apache.fineract.portfolio.savings.SavingsPostingInterestPeriodType;
import org.apache.fineract.portfolio.savings.service.SavingsEnumerations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountingDropdownReadPlatformServiceImpl implements AccountingDropdownReadPlatformService {

    private final GLAccountReadPlatformService accountReadPlatformService;

    @Override
    public List<EnumOptionData> retrieveGLAccountTypeOptions() {
        return AccountingEnumerations.gLAccountType(GLAccountType.values());
    }

    @Override
    public List<EnumOptionData> retrieveGLAccountUsageOptions() {
        return AccountingEnumerations.gLAccountUsage(GLAccountUsage.values());
    }

    @Override
    public List<EnumOptionData> retrieveJournalEntryTypeOptions() {
        return AccountingEnumerations.journalEntryTypes(JournalEntryType.values());
    }

    @Override
    public List<EnumOptionData> retrieveAccountingRuleTypeOptions() {
        return AccountingEnumerations.accountingRuleTypes(AccountingRuleType.values());
    }

    @Override
    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForLoanProducts() {
        return retrieveAccountMappingOptions();
    }

    @Override
    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForSavingsProducts() {
        return retrieveAccountMappingOptions();
    }

    @Override
    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForCharges() {
        // only get income and liability accounts
        boolean includeIncomeAccounts = true;
        boolean includeLiabilityAccounts = true;

        boolean includeAssetAccounts = false;
        boolean includeExpenseAccounts = false;
        boolean includeEquityAccounts = false;

        return retrieveAccountMappingOptions(includeAssetAccounts, includeIncomeAccounts, includeExpenseAccounts, includeLiabilityAccounts,
                includeEquityAccounts);
    }

    @Override
    public Map<String, List<GLAccountData>> retrieveAccountMappingOptions() {
        boolean includeAssetAccounts = true;
        boolean includeIncomeAccounts = true;
        boolean includeExpenseAccounts = true;
        boolean includeLiabilityAccounts = true;
        boolean includeEquityAccounts = true;
        return retrieveAccountMappingOptions(includeAssetAccounts, includeIncomeAccounts, includeExpenseAccounts, includeLiabilityAccounts,
                includeEquityAccounts);
    }

    @Override
    public List<GLAccountData> retrieveExpenseAccountOptions() {
        return accountReadPlatformService.retrieveAllEnabledDetailGLAccounts(GLAccountType.EXPENSE);
    }

    @Override
    public List<GLAccountData> retrieveAssetAccountOptions() {
        return accountReadPlatformService.retrieveAllEnabledDetailGLAccounts(GLAccountType.ASSET);
    }

    private Map<String, List<GLAccountData>> retrieveAccountMappingOptions(boolean includeAssetAccounts, boolean includeIncomeAccounts,
            boolean includeExpenseAccounts, boolean includeLiabilityAccounts, boolean includeEquityAccounts) {
        final Map<String, List<GLAccountData>> accountOptions = new HashMap<>();

        if (includeAssetAccounts) {
            List<GLAccountData> assetAccountOptions = this.accountReadPlatformService
                    .retrieveAllEnabledDetailGLAccounts(GLAccountType.ASSET);
            if (assetAccountOptions.isEmpty()) {
                assetAccountOptions = null;
            }
            accountOptions.put("assetAccountOptions", assetAccountOptions);
        }

        if (includeIncomeAccounts) {
            List<GLAccountData> incomeAccountOptions = this.accountReadPlatformService
                    .retrieveAllEnabledDetailGLAccounts(GLAccountType.INCOME);
            if (incomeAccountOptions.isEmpty()) {
                incomeAccountOptions = null;
            }
            accountOptions.put("incomeAccountOptions", incomeAccountOptions);
        }

        if (includeExpenseAccounts) {
            List<GLAccountData> expenseAccountOptions = this.accountReadPlatformService
                    .retrieveAllEnabledDetailGLAccounts(GLAccountType.EXPENSE);
            if (expenseAccountOptions.isEmpty()) {
                expenseAccountOptions = null;
            }
            accountOptions.put("expenseAccountOptions", expenseAccountOptions);
        }

        if (includeLiabilityAccounts) {
            List<GLAccountData> liabilityAccountOptions = this.accountReadPlatformService
                    .retrieveAllEnabledDetailGLAccounts(GLAccountType.LIABILITY);
            if (liabilityAccountOptions.isEmpty()) {
                liabilityAccountOptions = null;
            }
            accountOptions.put("liabilityAccountOptions", liabilityAccountOptions);
        }

        if (includeEquityAccounts) {
            List<GLAccountData> equityAccountOptions = this.accountReadPlatformService
                    .retrieveAllEnabledDetailGLAccounts(GLAccountType.EQUITY);
            if (equityAccountOptions.isEmpty()) {
                equityAccountOptions = null;
            }
            accountOptions.put("equityAccountOptions", equityAccountOptions);
        }
        return accountOptions;
    }

    @Override
    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForShareProducts() {
        boolean includeAssetAccounts = true;
        boolean includeIncomeAccounts = true;
        boolean includeExpenseAccounts = false;
        boolean includeLiabilityAccounts = true;
        boolean includeEquityAccounts = true;
        return retrieveAccountMappingOptions(includeAssetAccounts, includeIncomeAccounts, includeExpenseAccounts, includeLiabilityAccounts,
                includeEquityAccounts);
    }

    @Override
    public Collection<EnumOptionData> retrievePeriodTypeOptions() {
        final List<EnumOptionData> allowedOptions = Arrays.asList(
                SavingsEnumerations.interestPostingPeriodType(SavingsPostingInterestPeriodType.DAILY), //
                SavingsEnumerations.interestPostingPeriodType(SavingsPostingInterestPeriodType.MONTHLY));

        return allowedOptions;
    }

}
