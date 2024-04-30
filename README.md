### April 21 group contributions

youssef boshra-riad (yzb5142) 90%-95% of the effort:

- wrote dbIntegration
- set up database
- refactored Patient.java, User.java, Authenticator.java according to refactoring plan
- implemented backend for patient update use case for patients
- implemented backend for patient creation/update use case for caregivers
- implemented backend for patient lookup use case
- implemented a permission system throughout the system so that patients have restricted access to the system
- Redeisnged Login View
- Made changes to views and controllers according to refactoring plan
- patient info view + its controller (uses categorization UI design pattern I picked)

Carlos Dye (cmd6690) 5% of effort:
- Designed Login view
- Cretaed new home screen
- Created new views for corresponding use cases
- Implemented front end for use cases


### April 29 group contributions

youssef boshra-riad (yzb5142) 85% of the effort:

- All of the search patient functionality & the view
- Enhanced permission system to include multiple caregiver roles with differing priveleges, doctors and admin have different abilities.
- Connected all of the views and controllers to each other and themselves to make system work cohesively
- updated database information and added tables like a patient assignments table
- Re-formatted entire project to have a consistent visual style
- Re-designed all the views to have similar visual styles to improve overall system coherence
- Fully implemented patient assignment use case

  Carlos Dye (cmd6690) 15% of effort:
  - Cretaed Test class for appointment
  - Implemented appointment scheduleing use case
  - Refactored both appointment model and controller
    
### General Use Case and Design Pattern Contributions

youssef boshra-riad (yzb5142):

- Authentication/Login use case
- View/Update Patient Info as Patient use case
- View/Update/Create Patient Info as Caregiver use case
- Search for Patient as Caregiver use case
- Assign Patient to Doctor as Admin use case
- Singleton design pattern for Authenticator and dbIntegration classes
- Categorization design pattern for PatientInfoView view

  Carlos Dye (cmd6690):
- Authentication/Login use case (View) 
- View/Update Patient Info as Patient use case (View)
- View/Update/Create Patient Info as Caregiver use case (View)
- Search for Patient as Caregiver use case (View)
- Assign Patient to Doctor as Admin use case
- Appointment use case

### Use Instructions

There are three accounts available for testing purposes: 'admin', 'doctor', and 'patient'. The passwords for all these accounts is '1234'. See Test Cases document for available test cases and a description on how to execute them using the UI. Here are a few quick notes about interacting with the system:

- Personal info for a patient can only be modified by a doctor if that patient is assigned to that doctor.
- Patients can only be assigned to a doctor by an admin.

##### Priveleges

Admins:

- Can view/create patients
- Can update patient contact information for all patients
- Can search for patients
- Can assign patients to doctors

Doctors:

- Can view/create patient information
- Can update all patient information only for patients assigned to them
- Can search for patients

Patients:

- Can view own information
- Can update own contact info
