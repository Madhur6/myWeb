package com.example.Jwt.jwtPrac.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="my_user")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String email;
	
	@Column
	private String password;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id", referencedColumnName="id")
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		HashSet<GrantedAuthority> roleSet = new HashSet<>();
//		roleSet.add(new SimpleGrantedAuthority(this.role.getRoleName()));
//		return roleSet;
//		
		return Set.of(new SimpleGrantedAuthority(this.role.getRoleName()));
	}

	@Override
	public String getUsername() {
		return email;
	}
}


// JWT: Json Web Token [An open-source RFC method for representing claims securely b/w 2 parties.]
// parts -----------> 3 parts (x / y / z)

// x: Header: {"alg": "HS256", "typ": "JWT/AUTHORIZATION"}😊 [RED]

// y: Payload: <DATA> --> {"sub": "123456", "name":"HARRY-POTTER", "iat(issued at)":"123456"} [PINK]

// z: Signature: <Verification Signature> Includes encoded Header, Payload (E(Header) / E(Payload) + SECRET_KEY) [BLUE]

// Cipher: 
// Hashing: 
// Cryptography:

// cipher ----> "abc" ---encryption--> "bcd" ----decrypt ---------> -1 --> "abc" (⭐)
// ascii  ----> "96+1"

// Hashing 

// Hash----> Mathematical Formula -------> takes some input & returns some output

// CLIENT💻                                                                         // SERVER➕
// 1. POST/Authentication with username & Password -----------------------------> 2. VALIDATE THE USERNAME & PASSWORD [Generates the token using Secret key]
																							// |
// 3. Returns the generated token <-------------------------------------------------------------

// 4. GET/ DATA WITH JWT IN HEADER ----------------------------------------------> 5. Validate JWT token using secret-key ❔
																		  				    // |
// 6. Returns the Response <--------------------------------------------------------------------


// [Header(JWT)]
// Request -------------> Dispatcher Servlet -------> [Spring Security⭐] ----> Controller









//                       HttpSecurityFilterChain -------> HttpSecurity.build()
//                             ^
//                             |
//                             |
// Spring Security -----> Spring Security Filter Chain
//                             |
//                             V
// [ JWTFilter | UsernamePasswordAuthenticationFilter | CSRFFilter]

// UsernamePasswordAuthenticationFilter: Default filter-chain by SB
// JwtFilter: We add our own custom filter in front-of "Default-filter"
// 			  Extract the token and takes the necessary actions
// JwtUtil:   To generate the token / Validate the token / Extract the information(Subject / Expiration ) from token

// Additional Beans: Not part of above framework, But required by Spring-Security
// - UserDetails
// - UserDetailsService: To manipulate the user
// - PasswordEncoder:
// - AuthenticationManager: Uses authenticationProvider, Handles the public-end-points
// - AuthenticationProvider:  


















