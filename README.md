
<h1><a id="Phone_Exercise_Assignment"></a>User Phone Number Assignment</h1>
<p>This assignment is designed on spring-boot framework.</p>
<h2><a id="Installation_6"></a>Installation</h2>
<ol>
<li>Clone the source code<pre><code class="language-sh">git <span class="hljs-built_in">clone</span> https://github.com/iankurbansal/phone-exercise.git
</code></pre>
</li>
<li>Go to the checked out source code and start the server locally (Server will start on port 8081 , make sure no other is using the same port)<pre><code class="language-bash">mvn spring-boot:run
</code></pre>
</ol>
<h2><a id="Usage_20"></a>Usage</h2>
<p>When the server starts , internally following data is stored:</p>
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>UserId</th>
<th>Email</th>
<th>password</th>
<th>preffered phone no</th>
<th>userName</th>
</tr>
</thead>
<tbody>
<tr>
<td>7dc53df5703e49b38670b1c468f47f1f</td>
<td>ankur.ete@gmail.com</td>
<td>passwd</td>
<td>0876543323</td>
<td>eankuba</td>
</tr>
</tbody>
</table>

<table class="table table-striped table-bordered">
<thead>
<tr>
<th>PhoneId</th>
<th>Phone model</th>
<th>phone name</th>
<th>preffered phone no</th>
<th>user id</th>
</tr>
</thead>
<tbody>
<tr>
<td>6dc53df5703e49b38670b1c468f47f1f</td>
<td>1</td>
<td>my iphone</td>
<td>09876</td>
<td>null</td>
</tr>
</tbody>
</table>
<h2><a id="APIs_33"></a>APIs</h2>
<ul>
<li>
<p>Authenticate client  <a href="http://localhost:8080/authenticate">http://localhost:8080/authenticate</a><br>
This should be a post request with valid body like : {"username":"adminUser","password":"password"}.</p>
This call should return a token which should be added in header for all subsequent request headers to authenticate.
</li>
<li>
<p>Get All Phone Numbers  <a href="http://localhost:8081/phones">http://localhost:8081/phone</a><br>
This Api returns all the phone number deetails.</p>
</li>
<li>
<p>Get all phone numbers for a user <a href="http://localhost:8081/users/{userId}/phones">http://localhost:8081/users/7dc53df5-703e-49b3-8670-b1c468f47f1f/phones</a> – This returns the phone numbers of user with id : 7dc53df5-703e-49b3-8670-b1c468f47f1f</p>
</li>
<li>
<p>Add a phone number to user. This is a POST call since action is being performed. <a href="http://localhost:8080/users/addPhone/7dc53df5-703e-49b3-8670-b1c468f47f1f/6dc53df5-703e-49b3-8670-b1c468f47f1f">http://localhost:8080/users/addPhone/7dc53df5-703e-49b3-8670-b1c468f47f1f/6dc53df5-703e-49b3-8670-b1c468f47f1f</a></p>
</li>
<li>
<p>change preffered phone number for a user. This is a PATCH call since only one field is being modified. <a href="http://localhost:8080/users/changePreferredNumber/7dc53df5-703e-49b3-8670-b1c468f47f1f">http://localhost:8080/users/changePreferredNumber/7dc53df5-703e-49b3-8670-b1c468f47f1f</a></p>
The request should have a valid body like : [{"op":"replace","path":"/preferredPhoneNumber","value":"0015555678"}]
</li>
</ul>
<h2><a id="Exceptions_42"></a>Exceptions</h2>
<ul>
<li>UserNotFoundException : if the api input consis of the user is which is not availble in the system.</li>
<li>PhoneNotFoundException : if the api input consis of the phone is which is not availble in the system</li>
</ul>
