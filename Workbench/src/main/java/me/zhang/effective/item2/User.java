package me.zhang.effective.item2;

import java.util.Objects;

/**
 * Created by zhangxiangdong on 2017/12/18.
 */
public class User {

    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private User(UserBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        phone = builder.phone;
        address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static final class UserBuilder implements Builder<User> {
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String address;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = Objects.requireNonNull(firstName);
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = Objects.requireNonNull(lastName);
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }

    }
}
