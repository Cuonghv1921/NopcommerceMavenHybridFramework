package guiDataModel;

public class DataModel {
    public static class CustomerInfor {
        private String gender;
        private String firstName;
        private String lastName;
        private String dateOfbirth;
        private String emailAddress;
        private String companyName;
        private boolean newLetter;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDateOfbirth() {
            return dateOfbirth;
        }

        public void setDateOfbirth(String dateOfbirth) {
            this.dateOfbirth = dateOfbirth;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public boolean isNewLetter() {
            return newLetter;
        }

        public void setNewLetter(boolean newLetter) {
            this.newLetter = newLetter;
        }
    }

    public static class Address {
        private String addressFirstName;
        private String addressLastName;
        private String addressEmailAddress;
        private String addressCompany;
        private String addressCountry;
        private String addressStateProvince;
        private String addressCity;
        private String addressAddress1;
        private String addressAddress2;
        private String addressPostCode;
        private String addressPhoneNumber;
        private String addressFaxNumber;
        private String addressFullName;
        private String addressCityStateZip;

        public String getAddressFullName() {
            return addressFullName;
        }

        public void setAddressFullName(String addressFullName) {
            this.addressFullName = addressFullName;
        }

        public String getAddressCityStateZip() {
            return addressCityStateZip;
        }

        public void setAddressCityStateZip(String addressCityStateZip) {
            this.addressCityStateZip = addressCityStateZip;
        }

        public String getAddressFirstName() {
            return addressFirstName;
        }

        public void setAddressFirstName(String addressFirstName) {
            this.addressFirstName = addressFirstName;
        }

        public String getAddressLastName() {
            return addressLastName;
        }

        public void setAddressLastName(String addressLastName) {
            this.addressLastName = addressLastName;
        }

        public String getAddressEmailAddress() {
            return addressEmailAddress;
        }

        public void setAddressEmailAddress(String addressEmailAddress) {
            this.addressEmailAddress = addressEmailAddress;
        }

        public String getAddressCompany() {
            return addressCompany;
        }

        public void setAddressCompany(String addressCompany) {
            this.addressCompany = addressCompany;
        }

        public String getAddressCountry() {
            return addressCountry;
        }

        public void setAddressCountry(String addressCountry) {
            this.addressCountry = addressCountry;
        }

        public String getAddressStateProvince() {
            return addressStateProvince;
        }

        public void setAddressStateProvince(String addressStateProvince) {
            this.addressStateProvince = addressStateProvince;
        }

        public String getAddressCity() {
            return addressCity;
        }

        public void setAddressCity(String addressCity) {
            this.addressCity = addressCity;
        }

        public String getAddressAddress1() {
            return addressAddress1;
        }

        public void setAddressAddress1(String addressAddress1) {
            this.addressAddress1 = addressAddress1;
        }

        public String getAddressAddress2() {
            return addressAddress2;
        }

        public void setAddressAddress2(String addressAddress2) {
            this.addressAddress2 = addressAddress2;
        }

        public String getAddressPostCode() {
            return addressPostCode;
        }

        public void setAddressPostCode(String addressPostCode) {
            this.addressPostCode = addressPostCode;
        }

        public String getAddressPhoneNumber() {
            return addressPhoneNumber;
        }

        public void setAddressPhoneNumber(String addressPhoneNumber) {
            this.addressPhoneNumber = addressPhoneNumber;
        }

        public String getAddressFaxNumber() {
            return addressFaxNumber;
        }

        public void setAddressFaxNumber(String addressFaxNumber) {
            this.addressFaxNumber = addressFaxNumber;
        }
    }

    public static class ProductReview {
        private String reviewTitle;
        private String reviewBody;

        public String getReviewTitle() {
            return reviewTitle;
        }

        public void setReviewTitle(String reviewTitle) {
            this.reviewTitle = reviewTitle;
        }

        public String getReviewBody() {
            return reviewBody;
        }

        public void setReviewBody(String reviewBody) {
            this.reviewBody = reviewBody;
        }
    }

    public static class ProductDetails {
        String productName;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }
    }
}
