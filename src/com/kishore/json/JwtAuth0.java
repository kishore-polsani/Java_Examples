package com.kishore.json;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

public class JwtAuth0 {

    public static void main(String[] args) {
        //String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
        System.out.println("233");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkc3QiOiJteXRyIiwiZXhwIjoxNTM1MDE0NDAyLCJpYXQiOjE1MDM0Nzg0MDIsImlzcyI6Im15dHIiLCJzdWIiOiI3MDBkNTViYS01NmRkLTRlNGYtYmFmOC0xYThjNTMyMDRkMjQiLCJzdWJfZW1haWwiOiJrYWx5YW5hLmNoYWtyYXZhcnR5QHRob21zb25yZXV0ZXJzLmNvbSIsInN1Yl9ncmF2YXRhciI6IjRlOTU5OTY3YWEwZDQxMTc4MzUwOWY2MzFiNjc4NWRiIiwic3ViX25hbWUiOiJLYWx5YW5hIE5hZGlrdWRhIiwic3ViX3Byb3ZpZGVyLWlkIjoiR0VVUzEtNDc0ODEiLCJzdWJfcHJvdmlkZXItbmFtZSI6ImFhYSIsInRpZCI6IjFiNDQ5YzRjLWVmMWYtNDNlNS01ZDUwLTAzMjFlZjI5OWJhYSJ9.EjyyuFN6zDHuq2aeHojDsXiUvvg-AtAQjv5Dq-Q2sGA";
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt.getIssuedAt());
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
