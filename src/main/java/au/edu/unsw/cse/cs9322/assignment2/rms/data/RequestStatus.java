package au.edu.unsw.cse.cs9322.assignment2.rms.data;

public enum RequestStatus {

    NEW, // wait for an officer
    UNDER_REVIEW, // requester cannot modify
    ACCEPTED, // requester needs to pay
    ARCHIVED; // finished & officers won't see it
}
