<%-- 
    Document   : Part7
    Created on : Oct 7, 2021, 4:17:21 PM
    Author     : palak
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-US">
    <head>
        <title>Tuition Waiver Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Part6Style.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script>
            function EnableDisableOther(chkbox) {
                var employeeStatusOther = document.getElementById("employeeStatusOther");
                employeeStatusOther.disabled = chkbox.checked ? false : true;
                if (!employeeStatusOther.disabled) {
                    employeeStatusOther.focus();
                }
            }
        </script>
    </head>
    <body>
        <hr style="height:1px;border-top:3px solid #FF0000" />
        <img src="logo.png" class="logo" alt="Logo">
        <h1 style="text-align:center;">Tuition Waiver Form</h1>
        <form action="Part7Servlet.htm" method="GET">
            <table class="table-1">
                <tr>
                    <td colspan="8" class="tr-info">
                        This form is used by part-time faculty, part-time staff, retirees, their spouses or domestic partners and their dependents.
                        All full-time faculty and staff should use the online Tuition Waiver Form found on myNEU. Before completing this form,
                        please refer to the Tuition Waiver Program Guidelines. Be sure to include a Dependent Certification Form along with
                        the submission of this form for any dependent children.
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>Section 1</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>Academic Term:</td>
                    <td colspan="2"><input type="text" id="academicTerm" name="academicTerm" title="Enter your Academic Term" style="width:250px" placeholder="(Fall, Winter, Spring, or Summer)*" /></td>
                    <td>Academic Year:</td>
                    <td><input type="text" id="academicYear" name="academicYear" title="Enter your Academic Year" /></td>
                </tr>
                <tr>
                    <td>Employee Status:</td>
                    <td colspan="4">
                        <input type="radio" title="Select Employee Status" name="employeeStatus" value="P/T Staff"> P/T Staff
                        <input type="radio" title="Select Employee Status" name="employeeStatus" value="P/T Faculty"> P/T Faculty
                        <input type="radio" title="Select Employee Status" name="employeeStatus" value="Retiree"> Retiree
                        <input type="radio" title="Select Employee Status" name="employeeStatus" value="Other" onclick="EnableDisableOther(this)"> Other
                        <input type="text" id="employeeStatusOther" name="employeeStatusOther" title="Enter Employee Status" disabled/>
                    </td>
                </tr>
                <tr>
                    <td colspan="8" class="td-term">
                        * Terms with multiple sessions are considered one academic term for tuition waiver purposes e.g., summer sessions I and
                        II are considered one academic term.
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>Section 2</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>Student???s Name:</td>
                    <td><input type="text" id="name" name="name" title="Enter Student's Name" /></td>
                    <td>Relationship to Employee:</td>
                    <td><input type="text" id="relationshiptoEmployee" name="relationshiptoEmployee" title="Enter Relationship to Employee" /></td>
                    <td>Student???s NUID:</td>
                    <td><input type="text" id="studentNUID" name="studentNUID" title="Enter Student???s NUID" /></td>
                </tr>
                <tr>
                    <td>Employee???s Name: <br>(if different from Student???s)</td>
                    <td><input type="text" id="empName" name="empName" title="Enter Employee???s Name" /></td>
                    <td>Employee???s NUID:</td>
                    <td><input type="text" id="empNUID" name="empNUID" title="Enter Employee???s NUID" /></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td><input type="text" id="department" name="department" title="Enter Department" /></td>
                    <td>Campus Location:</td>
                    <td><input type="text" id="campusLocation" name="campusLocation" title="Enter Campus Location" /></td>
                    <td>Phone Number:</td>
                    <td><input type="number" id="phoneNumber" name="phoneNumber" title="Enter Phone Number" /></td>
                    <td>Supervisor???s Name:</td>
                    <td><input type="text" id="supervisorName" name="supervisorName" title="Enter Supervisor???s Name" /></td>
                </tr>
                <tr>
                    <th>Section 3</th>
                    <th class="th-1" colspan="3">Indicate the applicable school or program:</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td colspan="8">
                        <input type="radio" title="Select applicable school or program" name="program" value="Undergraduate Program"> Undergraduate Program
                        <input type="radio" title="Select applicable school or program" name="program" value="Law School"> Law School(excludes employees)
                        <input type="radio" title="Select applicable school or program" name="program" value="Doctoral Candidate"> Doctoral Candidate
                        <input type="radio" title="Select applicable school or program" name="program" value="cpsUndergraduate"> College of Professional Studies (CPS) Undergraduate
                        <input type="radio" title="Select applicable school or program" name="program" value="Graduate School"> Graduate School
                        <input type="radio" title="Select applicable school or program" name="program" value="cpsGraduate"> CPS Graduate School
                    </td>
                </tr>
                <tr>
                    <td colspan="8" class="tr-info-1">
                        One course per academic term may be taken one-half hour before the end of your workday. If this applies to you, this form must be signed by your supervisor below and approved by Human Resources Management.
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="8" class="tr-info-1">
                        Complete the following course information. If you are an employee taking a job related course, please attach the Job Related Designation Form to this waiver.
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="8">
                        <table class="nestedTable">
                            <tr>
                                <th>Course No.</th>
                                <th>Course Name</th>
                                <th>Supervisor Signature</th>
                                <th>Credit Hrs.</th>
                                <th>Day(s)</th>
                                <th>Time</th>
                            </tr>
                            <tr>
                                <td><input type="text" id="courseNo_1" name="courseNo_1" title="Enter Course Number" /></td>
                                <td><input type="text" id="courseName_1" name="courseName_1" title="Enter Course Name" /></td>
                                <td><input type="text" id="supervisorSignature_1" name="supervisorSignature_1" title="Enter Supervisor Name" placeholder="Enter Supervisor Name"/></td>
                                <td><input type="text" id="creditHrs_1" name="creditHrs_1" title="Enter Credit Hours" /></td>
                                <td><input type="text" id="days_1" name="days_1" title="Enter Days" /></td>
                                <td><input type="text" id="time_1" name="time_1" title="Enter Time" /><br>
                                    <input type="radio" title="Select AM" name="ampm_1" value="a.m.">a.m.
                                    <input type="radio" title="Select PM" name="ampm_1" value="p.m.">p.m.
                                </td>
                            </tr>
                            <tr>
                                <td><input type="text" id="courseNo_2" name="courseNo_2" title="Enter Course Number" /></td>
                                <td><input type="text" id="courseName_2" name="courseName_2" title="Enter Course Name" /></td>
                                <td><input type="text" id="supervisorSignature_2" name="supervisorSignature_2" title="Enter Supervisor Name" placeholder="Enter Supervisor Name"/></td>
                                <td><input type="text" id="creditHrs_2" name="creditHrs_2" title="Enter Credit Hours" /></td>
                                <td><input type="text" id="days_2" name="days_2" title="Enter Days" /></td>
                                <td><input type="text" id="time_2" name="time_2" title="Enter Time" /><br>
                                    <input type="radio" title="Select AM" name="ampm_2" value="a.m.">a.m.
                                    <input type="radio" title="Select PM" name="ampm_2" value="p.m.">p.m.
                                </td>
                            </tr>
                            <tr>
                                <td><input type="text" id="courseNo_3" name="courseNo_3" title="Enter Course Number" /></td>
                                <td><input type="text" id="courseName_3" name="courseName_3" title="Enter Course Name" /></td>
                                <td><input type="text" id="supervisorSignature_3" name="supervisorSignature_3" title="Enter Supervisor Name" placeholder="Enter Supervisor Name"/></td>
                                <td><input type="text" id="creditHrs_3" name="creditHrs_3" title="Enter Credit Hours" /></td>
                                <td><input type="text" id="days_3" name="days_3" title="Enter Days" /></td>
                                <td><input type="text" id="time_3" name="time_3" title="Enter Time" /><br>
                                    <input type="radio" title="Select AM" name="ampm_3" value="a.m.">a.m.
                                    <input type="radio" title="Select PM" name="ampm_3" value="p.m.">p.m.
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <th>Section 4</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td colspan="8" class="section4-info">
                        In accordance with Northeastern University's Tuition Waiver Program Guidelines, my signature attests that I am
                        currently enrolled in the above courses, or that the student listed above is my spouse, domestic partner or
                        unmarried dependent child or the dependent child of my domestic partner as defined under current IRS tax
                        regulations. I also certify that I have read the Tuition Waiver Program Guidelines.
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Employee???s Signature:</td>
                    <td><input type="text" id="empSignature" name="empSignature" title="Enter Employee Name" placeholder="Enter Employee Name"/></td>
                    <td>Date:</td>
                    <td><input type="date" id="employeeSignDate" title="Select Date" name="employeeSignDate"></td>
                </tr>
                <tr>
                    <th>Section 5</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>HRM Approval:</td>
                    <td><input type="text" id="HRMsignature" name="HRMsignature" title="Enter HRM Approval Name" placeholder="Enter HRM Approval Name"/></td>
                    <td>Date:</td>
                    <td><input type="date" id="HRMSignDate" title="Select Date" name="HRMSignDate"></td>
                </tr>
                <tr>
                    <td colspan="8" class="tr-info-1">
                        Forms will be reviewed for completeness and eligibility. You will be notified if any additional information is needed. Mail completed form to
                        <b>Human Resources, 250 Columbus Place</b> or <b>fax to (617) 373-7610</b>. All waivers must be received by HRM within 30 days
                        of the course start date.
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr></tr>
                <tr>
                    <td align="center" colspan="8"><input type="submit" class="button-1" title="Submit Form" value="Submit" style="width:80px" /></td>
                </tr>
            </table>
        </form>
        <hr style="height:1px;border-top:3px solid #FF0000" />
        <img src="HRNavigator.PNG" class="HRNavigatorlogo" alt="HRNavigatorLogo">
        <br>
    </body>
</html>
