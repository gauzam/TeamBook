import React, { useState } from 'react'
import { createEmployee } from '../services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');

    const {id} = useParams();

    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: ''
    })

    const navigator = useNavigate();

    const handleFirstName = (e) => setFirstName(e.target.value);

    const handleLastName = (e) => setLastName(e.target.value);

    const handleEmail = (e) => setEmail(e.target.value);

    function saveEmployee(e){
        e.preventDefault();

        if(validateForm()){
            const employee = {firstName, lastName, email}
            console.log(employee)
            createEmployee(employee).then((response) => {
            console.log(response.data);
            navigator('/employees')
            })
        }
        
    }

    function validateForm(){
        let valid = true;

        const errorsCopy = {... errors};

        if(firstName.trim()){
            // first name is not empty
            errorsCopy.firstName = '';
        }
        else{
            errorsCopy.firstName = 'First Name is required.';
            //validation failed so we update boolean
            valid = false;
        }

        if(lastName.trim()){
            // last name is not empty
            errorsCopy.lastName = '';
        }
        else{
            errorsCopy.lastName = 'Last Name is required.';
            valid = false;
        }

        if(email.trim()){
            // email is not empty
            errorsCopy.email = '';
        }
        else{
            errorsCopy.email = 'Email is required.';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function pageTitle(){

        if(id){
            return <h2 className='text-center'>Update the Team Member</h2>
        }
        else{
            return <h2 className='text-center'>Add a Team Member</h2>
        }

    }

  return (
    <div className='container'>
        <br /> <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                { pageTitle() }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name:</label>
                            <input 
                                type='text'
                                placeholder='Enter Employee First Name'
                                name='firstName'
                                value={firstName}
                                className={`form-control ${ errors.firstName ? 'is-invalid' : '' }`}
                                onChange={handleFirstName}
                            > 
                            </input>
                            {errors.firstName && <div className='invalid-feedback'> {errors.firstName} </div>}
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Last Name:</label>
                            <input 
                                type='text'
                                placeholder='Enter Employee Last Name'
                                name='lastName'
                                value={lastName}
                                className={`form-control ${ errors.lastName ? 'is-invalid' : '' }`}
                                onChange={handleLastName}
                            > 
                            </input>
                            {errors.lastName && <div className='invalid-feedback'> {errors.lastName} </div>}
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Email:</label>
                            <input 
                                type='text'
                                placeholder='Enter Employee Email ID'
                                name='email'
                                value={email}
                                className={`form-control ${ errors.email ? 'is-invalid' : '' }`}
                                onChange={handleEmail}
                            > 
                            </input>
                            {errors.email && <div className='invalid-feedback'> {errors.email} </div>}
                        </div>

                        <button className='btn btn-success' onClick={saveEmployee}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeComponent