# Hospital Mapping and Recommendation System
## Abstract
The project aims at providing the easy, efficient and accountable system by making a Command line
application which manages everything from recommending and mapping patient to hospital to the final
billing.
So, the program uses user’s location and hospital’s location from database to give list of nearest hospitals.
User can choose department based on the disease user has and then doctors who are available. As the
patient get admitted, room is allotted to him/her. Then the lab tests given by doctor are performed on
patient.
Later, all the lab tests that are done, doctors and hospital and patient details are added to patient’s
medical record. Medical record also has all the data about the diseases patient previously had. Using all
these data in medical records bill is calculated.
Program uses concept of Object-Oriented Programming and for implementing OOPs we use Java
programming language.

## Problem Definition
Finding the right hospital and then managing all your records from doctors, LabTests, room allotment and
billing is always a tough task. Our project aims at easing it. Just using your location, you can get list of all of
the nearest hospitals and can admit in any one them. You can choose doctor of your choice. Also, hospitals
given have reviews to take an informed decision. Once these are done, you get into hospital. Then all lab
tests given by doctor are told to you in advance and even their result is added to your medical records.
With these the room allotted is also added after confirmation from you to your profile. Your admit-status
in patient’s profile is updated to ‘Yes’. A stay period as recommended by doctor is given (we generate it
randomly as there is no doctor’s module). Once stay period ends the bill is generated and also the final
medical report is shown to patient. At last mode of payment is asked and payment is done which ends the
program.
First the user has to enter his token number which for current database are from 1 to 40.
The system uses user's location and from database gives the list of 10 nearest Hospital.
User has to choose from anyone of the 10 hospitals, any other character entered won’t be accepted
and user has to enter right input again.
Then user will have to input department from list.
Next the user chooses doctor which also initiate the medical record of the person which contain all
the medical history of the person which is needed to initiate the treatment.
Later the person visits the doctor and the doctor recommends Lab Tests which are visible to person
on his system.
Reports of lab tests, are added to patient’s medical records for reference of patient and doctor in
two parts, one which is normal and another one which needs doctor’s attention.
Also, the room is allotted to the person for the stay time as recommended by doctor. It is ensured
that another patient is not allotted the same room by updating this room as ‘Allotted’ in the file.
A specific period of stay at hospital is recommended by doctor, after that much time person is
discharged.
After the stay time at hospital is over bill is generated and mode of payment is asked to person and
asked to pay the bill using that mode.
