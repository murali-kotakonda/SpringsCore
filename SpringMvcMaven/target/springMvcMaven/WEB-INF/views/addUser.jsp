<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<table>
			<tr>
				<td>First Name</td>
				<td>
				<form:input path="firstname" />
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Email </td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Telephone </td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:select path="city">
						<form:option value="hyd" label="Hyderabad" />
						<form:option value="bang" label="Bangalore" />
						<form:option value="pune" label="Pune" />
						<form:option value="che" label="Chennai" />
					</form:select></td>
			</tr>
		<tr>
			<td>Gender:</td>
			<td>
			Male<form:radiobutton path="gender" value="Male" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			Female<form:radiobutton path="gender" value="Female" />
			</td>
		</tr>

	<tr>
			<td>Id Proofs:</td>  
        <td>Voter <form:checkbox path="idProofs" value="Voter"/>  
        Pan <form:checkbox path="idProofs" value="Pan"/>  
        passport<form:checkbox path="idProofs" value="passport"/>  
        </td> 
    </tr>
    
    <tr>
			<td>Address:</td>  
        <td> 
        <form:textarea path="address" />  
        </td> 
    </tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add User" /></td>
			</tr>
		</table>
