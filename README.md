# OpenWhisk_actions

to update the already existed action you can use below line


$ bx wsk action update openWhiskTester target/OpenWhiskTester-0.0.1-SNAPSHOT.jar --main edu.uw.tcss562.navid.openwhisk.Action3


and to create action you can use below:

$ bx wsk action create openWhiskTester target/OpenWhiskTester-0.0.1-SNAPSHOT.jar --main edu.uw.tcss562.navid.openwhisk.Action3

to execute/invoke the action you can use below

$ bx wsk action invoke --result openWhiskTester --param <inputParam> <value of that arg> --blocking