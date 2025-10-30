print("userObj inside initialize_department.js :: " + JSON.stringify(userObj));
print("userObj2 inside initialize_department.js :: " + JSON.stringify(userObj2));
print("userObj3 inside initialize_department.js :: " + JSON.stringify(userObj3));
print("userObj4 inside initialize_department.js :: " + JSON.stringify(userObj4));

print("userObj4 inside initialize_department.js via execution.getVariable:: " + JSON.stringify(execution.getVariable("userObj4")));

var obj = {
	id: 1,
	name: 'IT'
}

print("departmentObj :: " + JSON.stringify(obj));