Feature: Login Page
Description: Automationg the login page using Cucumber

Scenario: Login using DataTable
Given Open Browser

When Open URL "http://practice.automationtesting.in/"
And Click on MyAccount
And Enter Username and Password
| pavanoltrainig | Test@selenium |
And Click on Login

Then Test Case Passed
