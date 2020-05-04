package com.example.myapplication;

import com.google.firebase.firestore.auth.User;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class user {
    private static final String emailValidation = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private String image;
    private String firstN;
    private String lastN;
    private String email;
    private String phone;
    private Pattern emailValid;


    public user() {
        image="";
        firstN = " ";
        lastN = "";
        email = "";
        phone ="";
        emailValid = Pattern.compile(emailValidation);

    }
    public user ( String firstName, String lastName,String emailA, String phonenum) {

        firstN = firstName;
        lastN = lastName;
        email = emailA;
        phone = phonenum;
    }
    public void setImage(String img)
    {
        this.image = img;
    }
    public String getImage()
    {
        return image;
    }
    public void setFirstN(String firstN)
    {
        this.firstN = firstN;
    }
    public String getFirstN()
    {
        return firstN;
    }
    public void setLastN(String lastN)
    {
        this.lastN = lastN;
    }
    public String getLastN()
    {
        return lastN;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }
    public void setPhone(String phoneNum)
    {
        this.phone = phoneNum;
    }
    public String getPhone()
    {
        return phone;
    }
    public boolean isEmailValid()
    {
        Matcher match = emailValid.matcher(email);
        return  match.matches();
    }
    public boolean isFirstNameValid()
    {
        if (firstN == null|| firstN.isEmpty())
        {
            return false;
        }
        return true;
    }
    public boolean isLastNameValid()
    {
        if (lastN == null || lastN.isEmpty())
        {
            return false;
        }
        return true;
    }
    public boolean isImageValid()
    {
        if (image == null|| image.isEmpty())
        {
            return false;
        }
        return true;
    }
    public boolean isPhoneValid()
    {
        if (phone == null|| phone.isEmpty())
        {
            return false;
        }
        return true;
    }
}



