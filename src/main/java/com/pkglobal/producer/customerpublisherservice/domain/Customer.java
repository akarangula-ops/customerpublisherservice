package com.pkglobal.producer.customerpublisherservice.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

/**
 * Customer
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-17T09:38:54.954Z")


public class Customer   {
  @JsonProperty("customerNumber")
  private String customerNumber = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastname")
  private String lastname = null;

  @JsonProperty("birthdate")
  private OffsetDateTime birthdate = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("mobileNumber")
  private Integer mobileNumber = null;

  @JsonProperty("email")
  private String email = null;

  /**
   * Gets or Sets customerStatus
   */
  public enum CustomerStatusEnum {
    OPEN("open"),
    
    CLOSE("close"),
    
    SUSPENDED("suspended"),
    
    RESTORED("restored");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatusEnum fromValue(String text) {
      for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("customerStatus")
  private CustomerStatusEnum customerStatus = null;

  @JsonProperty("address")
  private Address address = null;

  public Customer customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  /**
   * Get customerNumber
   * @return customerNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull


  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
  **/
  @ApiModelProperty(value = "")


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Customer birthdate(OffsetDateTime birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Get birthdate
   * @return birthdate
  **/
  @ApiModelProperty(value = "")

  @Validated

  public OffsetDateTime getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(OffsetDateTime birthdate) {
    this.birthdate = birthdate;
  }

  public Customer country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Customer countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Customer mobileNumber(Integer mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * @return mobileNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull


  public Integer getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Integer mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer customerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  /**
   * Get customerStatus
   * @return customerStatus
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull


  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }

  public Customer address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(required = true, value = "")
  @NonNull

  @Validated

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerNumber, customer.customerNumber) &&
        Objects.equals(this.firstName, customer.firstName) &&
        Objects.equals(this.lastname, customer.lastname) &&
        Objects.equals(this.birthdate, customer.birthdate) &&
        Objects.equals(this.country, customer.country) &&
        Objects.equals(this.countryCode, customer.countryCode) &&
        Objects.equals(this.mobileNumber, customer.mobileNumber) &&
        Objects.equals(this.email, customer.email) &&
        Objects.equals(this.customerStatus, customer.customerStatus) &&
        Objects.equals(this.address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, firstName, lastname, birthdate, country, countryCode, mobileNumber, email, customerStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

