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

package org.apache.fineract.portfolio.client.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import org.apache.fineract.infrastructure.codes.data.CodeValueData;

public final class ClientFamilyMembersData implements Serializable {

    private final Long id;

    private final Long clientId;

    private final String firstName;

    private final String middleName;

    private final String lastName;

    private final String qualification;

    private final Long relationshipId;

    private final String relationship;

    private final Long maritalStatusId;

    private final String maritalStatus;

    private final Long genderId;

    private final String gender;

    private final LocalDate dateOfBirth;

    private final Long professionId;

    private final String profession;

    private final String mobileNumber;

    private final Long age;

    private final Boolean isDependent;

    private String email;

    private String address1;

    private String address2;

    private String address3;

    private String postalCode;

    private Long stateProvinceId;

    private Long countryId;

    private String countryName;

    private String stateName;

    private Long cityId;

    private String cityName;

    // template holder
    private final Collection<CodeValueData> relationshipIdOptions;
    private final Collection<CodeValueData> genderIdOptions;
    private final Collection<CodeValueData> maritalStatusIdOptions;
    private final Collection<CodeValueData> professionIdOptions;

    private final Collection<CodeValueData> countryIdOptions;
    private final Collection<CodeValueData> stateProvinceIdOptions;
    private final Collection<CodeValueData> cityIdOptions;
    private final Collection<CodeValueData> addressTypeIdOptions;
    private final Long addressTypeId;
    private final String addressType;

    private ClientFamilyMembersData(final Long id, final Long clientId, final String firstName, final String middleName,
            final String lastName, final String qualification, final String mobileNumber, final Long age, final Boolean isDependent,
            final String relationship, final Long relationshipId, final String maritalStatus, final Long maritalStatusId,
            final String gender, final Long genderId, final LocalDate dateOfBirth, final String profession, final Long professionId,
            String email, String address1, String address2, String address3, String postalCode, Long stateProvinceId, Long countryId,
            String countryName, String stateName, Long cityId, String cityName, final Collection<CodeValueData> relationshipIdOptions,
            final Collection<CodeValueData> genderIdOptions, final Collection<CodeValueData> maritalStatusIdOptions,
            final Collection<CodeValueData> professionIdOptions, Collection<CodeValueData> countryIdOptions,
            Collection<CodeValueData> stateProvinceIdOptions, Collection<CodeValueData> cityIdOptions,
            Collection<CodeValueData> addressTypeIdOptions, Long addressTypeId, String addressType) {
        this.id = id;
        this.clientId = clientId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.relationship = relationship;
        this.relationshipId = relationshipId;
        this.maritalStatus = maritalStatus;
        this.maritalStatusId = maritalStatusId;
        this.gender = gender;
        this.genderId = genderId;
        this.dateOfBirth = dateOfBirth;
        this.profession = profession;
        this.professionId = professionId;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.isDependent = isDependent;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.postalCode = postalCode;
        this.stateProvinceId = stateProvinceId;
        this.countryId = countryId;
        this.countryName = countryName;
        this.stateName = stateName;
        this.cityId = cityId;
        this.cityName = cityName;
        this.relationshipIdOptions = relationshipIdOptions;
        this.genderIdOptions = genderIdOptions;
        this.maritalStatusIdOptions = maritalStatusIdOptions;
        this.professionIdOptions = professionIdOptions;
        this.countryIdOptions = countryIdOptions;
        this.stateProvinceIdOptions = stateProvinceIdOptions;
        this.cityIdOptions = cityIdOptions;

        this.addressTypeIdOptions = addressTypeIdOptions;
        this.addressTypeId = addressTypeId;
        this.addressType = addressType;
    }

    public static ClientFamilyMembersData instance(final Long id, final Long clientId, final String firstName, final String middleName,
            final String lastName, final String qualification, final String mobileNumber, final Long age, final Boolean isDependent,
            final String relationship, final Long relationshipId, final String maritalStatus, final Long maritalStatusId,
            final String gender, final Long genderId, final LocalDate dateOfBirth, final String profession, final Long professionId,
            String email, String address1, String address2, String address3, String postalCode, Long stateProvinceId, Long countryId,
            String countryName, String stateName, Long cityId, String cityName, Long addressTypeId, String addressType) {
        return new ClientFamilyMembersData(id, clientId, firstName, middleName, lastName, qualification, mobileNumber, age, isDependent,
                relationship, relationshipId, maritalStatus, maritalStatusId, gender, genderId, dateOfBirth, profession, professionId,
                email, address1, address2, address3, postalCode, stateProvinceId, countryId, countryName, stateName, cityId, cityName, null,
                null, null, null, null, null, null, null, addressTypeId, addressType);
    }

    public static ClientFamilyMembersData templateInstance(final Collection<CodeValueData> relationshipIdOptions,
            final Collection<CodeValueData> genderIdOptions, final Collection<CodeValueData> maritalStatusIdOptions,
            final Collection<CodeValueData> professionIdOptions, Collection<CodeValueData> countryIdOptions,
            Collection<CodeValueData> stateProvinceIdOptions, Collection<CodeValueData> cityIdOptions,
            Collection<CodeValueData> addressTypeIdOptions) {

        return new ClientFamilyMembersData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, relationshipIdOptions, genderIdOptions,
                maritalStatusIdOptions, professionIdOptions, countryIdOptions, stateProvinceIdOptions, cityIdOptions, addressTypeIdOptions,
                null, null);
    }

    public Long getId() {
        return this.id;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getQualification() {
        return this.qualification;
    }

    public Long getRelationshipId() {
        return this.relationshipId;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public Long getMaritalStatusId() {
        return this.maritalStatusId;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public Long getGenderId() {
        return this.genderId;
    }

    public String getGender() {
        return this.gender;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Long getProfessionId() {
        return this.professionId;
    }

    public String getProfession() {
        return this.profession;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public Long getAge() {
        return this.age;
    }

    public Boolean getIsDependent() {
        return this.isDependent;
    }

}
