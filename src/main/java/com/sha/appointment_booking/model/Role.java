//why we use enum classes for roles? using an enum for roles ensures a robust, clear, and maintainable way to manage the different access levels in your application.

package com.sha.appointment_booking.model;

public enum Role {
    USER, //this is the default role
    ADMIN, //used for CRUD operations
    SYSTEM_MANAGER // used for internal-system operations
}
