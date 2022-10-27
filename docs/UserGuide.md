# User Guide

## Features
* Adding a patient (add)
* Search for a patient (search)
* Edit patient details (edit)
* Find patients (findpatient/fp)
* Find appointments (findappointment/fa)
* Find bills (findbill/fb)
* Sort (sort)


### Adding a patient: `add` [coming soon]

Adds a patient and his/her details, such as age, contact number and appointment date, to the app.

Format with example of usage: (in Command Terminal)

````
> add

Enter patient’s name:

> Mrs Angeline Tan

Enter patient’s age:

> 35

Enter patient’s contact number:

> 91234567

Enter patient’s next appointment date:

> 5/10/22

Mrs Angeline Tan has been added!
Name: Mrs Angeline Tan
Age: 35
Contact number: 91234567
Appointment Date: 5/10/22
````

### Editing a patient: `editpatient` `ep`

Edit a patient’s information, such as name, phone, email, address, remark and tag.

Format: `editpatient INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`
* If there is no such patient to edit, it will show an error.
* Existing values will be updated to the input values.
* Edits the patient at the specified `INDEX`. The index refers to the index number shown in the displayed patient list. 
   The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.
* You can remove all the patient’s tags by typing `t/` without
  specifying any tags after it.

Examples:
Examples:
* `editpatient 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st patient to be `91234567` 
   and `johndoe@example.com` respectively.
* `editpatient 2 n/Betsy Crower t/` Edits the name of the 2nd patient to be `Betsy Crower` and clears all existing tags


### Editing a bill: `editbill` `eb`

Edit a bill’s information, such as amount, bill's date.

Format: `editbill <prefix> <input>` or `eb <prefix> <input>`

* The command words are `editbill` or `eb`.
* If there is no such bill to edit, it will show an error.
* Existing values will be updated to the input values.
* Prefix are a/ for amount, d/ for bill's date.

Examples:
* `editbill 1 a/100 d/ 2019-12-25` The first bill's amount has been changed to $100 
   and bill's date has been changed to Dec 25th, 2019.



### Finding patients `findpatient` `fp`

Filters patients by one or more fields using their prefixes, and their corresponding inputs (numbers, letters,
special characters).

Format:
```findpatient <prefix><input> ...``` or ```fp <prefix><input>...```

* The command words are ``findpatient`` or ``fp``.
* The prefixes are n/ for Name, p/ for Phone, e/ for Email, a/ for Address, r/ for Remark and t/ for Tags.
* The filter is case-insensitive. e.g. han will match Han
* Can filter using full words or partial words. e.g. han will match Hannah
* Can filter using a combination of inputs for a field, according to the constraints of the field. 
  e.g. e/@gmail.com
* Can filter using one field or multiple fields at once. e.g. n/John p/91234567
* If there are no prefixes keyed in, an error message will be shown with the correct command format.
* If the input after a prefix is empty/invalid, an error message with the constraint of the field will be shown.

Examples:
* ```findpatient n/ale``` returns ``Alex Yeoh`` and ``alex tan``.
  
<img src="images/findpatientAlex.png" width="800px" height ="400px">

* ```fp t/friends t/colleagues n/bernice``` returns only ``Bernice Yu`` with the tags ``friends`` and ``colleagues``.

<img src="images/findpatientBernice.png" width="800px" height ="400px">


### Sorting by criteria: `sort` [coming soon]

Sorts the patients according to name or appointment date.

Format :
```
sort by <criteria>
```
where `criteria` can be either `name` or `appointment date`.

Examples :
```
> sort by appointment date

Patients sorted by their appointment dates -
Jack Oct 12, 2022
John Oct 20, 2022
Peter Nov 1, 2022
Lara Jan 6, 2023
```

```
> sort by name

Patients sorted by name -
Alice
Bob
Jack
John 
Peter
```
