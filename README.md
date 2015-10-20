# Multilevel-Marketing

It is all about the whole business model with different role and different functionalities.

-This is final project so it is all about the whole business model with different role and different functionalities.
-I have created a MultiLevel Marketing Portal for business.
-All the requirements are fulfilled as follows:
-All the Entities are created.
-They have been related to one another using either OneToOne, OneToMany or ManyToMany relationships.
-A new jdbcRealm Security Realm in Glassfish with your User and Group tables.
-Three security roles for your application have been defined: admin,customers and members.
-One web-resource-collections and auth-constraints to protect some or all of your application.
-An auth-config that specifies Forms-Based Authentication using your security realm.
-Mapping of roles to users and groups using glassfish-web.xml
-CSS and Foundation is used for layout the application.
-All the code used in this project are based on "Instructor's Example"

Design

  -This is a final project regarding the whole functionality and security provided to business model.
  -As I created a MultiLevel Marketing type of business model for CRM business, so in my project I have given three       roles: admin,customers and members.
  -Customers can login and see their details and see the all products which are available and make a purchase it.
  -Members can login and see their details and see the all products which are available and make a purchase it in         addition they can manage their marketing tree.
  -Admin can login and see the all functionality of the portal and can make change or create new functionalists also.
  -There are only three portal, which shows a login page and when user enter the details of login then they get           admin,customer or member portal and there is a link to logout at the top of the page, there is username also at top    of dropdown and the can click the logout button and the user will be logged out and redirect to login page.
  -I did some extra credits which all are in code itself.

Development Insights

  -It has been great experience working on this project.
  -I loved the way we create database and add the data in it. How easy it is to create tables and add data to it and      create foreign key relationships without even writing the sql queries.
  -I liked the way we give security to different roles and restrict them from accessing the secure parts on our           website.
  -I like working with persistence and the security layers.
  -I like to work with JSF and thinking to use in future fr better prospect.

Requirements (Installation, Compile, Runtime, etc)

  -Open the project in Netbeans.
  -Created database named "itmd4515" and create a user named "itmd4515" with password "itmd4515" and give access to the    database "itmd4515" just created.
  -Go to your database and add a connection to the database "itmd4515".
  -Add persistence unit "jsharma3PU" and use the database connection added in previous step.
  -Create JDBC connection pool named "itmd4515Pool" and JDBC connection resource named "jdbc/itmd4515DS" and use the      pool created.
  -Now you can run the project.
  -The Tools used in the project is "NetBeans IDE version 8.0.2"
  -The libraries used are persistence, security, util,javax,facelate composite component ejb, etc.
