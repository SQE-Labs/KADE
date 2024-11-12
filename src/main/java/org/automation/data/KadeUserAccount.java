package org.automation.data;


public enum KadeUserAccount {

        Default("6465551114", "Test@123"),
        Customer("new_user123@yopmail.com", "Test@123"),

        Manager("asd", "asd");

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
