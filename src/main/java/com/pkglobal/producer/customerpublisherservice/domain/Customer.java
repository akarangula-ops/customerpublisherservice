package com.pkglobal.producer.customerpublisherservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/** Customer */
@Validated
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2021-03-17T09:38:54.954Z")
public class Customer {
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
   *
   * @return customerNumber
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field customerNumber is required")
  @Pattern(
      regexp = "^[a-zA-Z0-9]*$",
      message = "The field customerNumber is invalid. It should be alphanumeric")
  @Size(max = 10, message = "The field customerNumber is invalid. Maximum size should be 10")
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
   *
   * @return firstName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field firstName is required")
  @Size(
      min = 10,
      max = 50,
      message =
          "The field firstName is invalid. The field firstName must be a string with minimum and maximum lengths of 10 and 50")
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
   *
   * @return lastname
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field lastName is required")
  @Size(
      min = 10,
      max = 50,
      message =
          "The field lastName is invalid. The field lasName must be a string with minimum and maximum lengths of 10 and 50")
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
   *
   * @return birthdate
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field birthDate is required")
  @Pattern(
      regexp = "^\\d{2}-\\d{2}-\\d{4}$",
      message =
          "The field birthDate is invalid. The field birthDate should be in format DD-MM-YYYY")
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
   *
   * @return country
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field country is required")
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
   *
   * @return countryCode
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field country is required")
  @Size(
      max = 2,
      message =
          "The field country code is valid. The field country code must be a string with maximum length 2")
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
   *
   * @return mobileNumber
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field mobile number is required")
  @Pattern(
      regexp = "/[2-9]{2}\\d{8}/",
      message =
          "The field mobile number is invalid. The field mbile number should be numebrs with maximum 10 digits")
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
   *
   * @return email
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull(message = "The field email number is required")
  @Email(
      regexp = ".+@.+\\..+",
      message = "The field email is invalid. The field email should be of pattern abc@gmail.com")
  @Size(
      max = 50,
      message =
          "The field email is invalid. The field email should be a string with maximum size 50")
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
   *
   * @return customerStatus
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
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
   *
   * @return address
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
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
    return Objects.equals(this.customerNumber, customer.customerNumber)
        && Objects.equals(this.firstName, customer.firstName)
        && Objects.equals(this.lastname, customer.lastname)
        && Objects.equals(this.birthdate, customer.birthdate)
        && Objects.equals(this.country, customer.country)
        && Objects.equals(this.countryCode, customer.countryCode)
        && Objects.equals(this.mobileNumber, customer.mobileNumber)
        && Objects.equals(this.email, customer.email)
        && Objects.equals(this.customerStatus, customer.customerStatus)
        && Objects.equals(this.address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        customerNumber,
        firstName,
        lastname,
        birthdate,
        country,
        countryCode,
        mobileNumber,
        email,
        customerStatus,
        address);
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
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /** Gets or Sets customerStatus */
  public enum CustomerStatusEnum {
    OPEN("open"),

    CLOSE("close"),

    SUSPENDED("suspended"),

    RESTORED("restored");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
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

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }
  }
}
