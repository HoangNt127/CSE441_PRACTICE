package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmployeeViewModel extends ViewModel {

    private final MutableLiveData<String> employeeID = new MutableLiveData<>();
    private final MutableLiveData<String> employeeName = new MutableLiveData<>();
    private final MutableLiveData<String> employeeBirth = new MutableLiveData<>();
    private final MutableLiveData<String> employeeSalary = new MutableLiveData<>();

    public void setEmployeeID(String id) {
        employeeID.setValue(id);
    }

    public LiveData<String> getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeName(String name) {
        employeeName.setValue(name);
    }


    public LiveData<String> getEmployeeName() {
        return employeeName;
    }


    public void setEmployeeBirth(String birth) {
        employeeBirth.setValue(birth);
    }


    public LiveData<String> getEmployeeBirth() {
        return employeeBirth;
    }

    public void setEmployeeSalary(String salary) {
        employeeSalary.setValue(salary);
    }


    public LiveData<String> getEmployeeSalary() {
        return employeeSalary;
    }
}
