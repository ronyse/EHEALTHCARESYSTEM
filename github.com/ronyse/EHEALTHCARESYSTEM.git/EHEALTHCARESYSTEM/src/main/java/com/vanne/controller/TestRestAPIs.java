package com.vanne.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class TestRestAPIs {
 
 @GetMapping("/api/test/pat")
 @PreAuthorize("hasRole('PATIENT') or hasRole('ADMIN')")
 public String userAccess() {
 return ">>> Patient Contents!";
 }
 
 @GetMapping("/api/test/doct")
 @PreAuthorize("hasRole('DOCTOR') or hasRole('ADMIN')")
 public String projectManagementAccess() {
 return ">>> Doctor contents";
 }
 
 @GetMapping("/api/test/adm")
 @PreAuthorize("hasRole('ADMIN')")
 public String adminAccess() {
 return ">>> Admin Contents";
 }
}