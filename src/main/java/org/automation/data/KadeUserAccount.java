package org.automation.data;


public enum KadeUserAccount {

        Default("6465551114", "Test@123"),
        Customer("yonro@yopmail.com", "Test@123"),
        Admin("6465551113", "Test@123"),
        SearchUser("Kadesearch@yopmail.com","Test@123");

        private KadeUserAccount(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        private String userName;
        private String password;

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
