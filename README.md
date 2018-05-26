# OpenWhisk_actions

to update the already existed action you can use below line

##create/update action
$ bx wsk action update openWhiskTester target/OpenWhiskTester-0.0.1-SNAPSHOT.jar --main edu.uw.tcss562.navid.openwhisk.Action3


and to create action you can use below:

$ bx wsk action create openWhiskTester target/OpenWhiskTester-0.0.1-SNAPSHOT.jar --main edu.uw.tcss562.navid.openwhisk.Action3

##invoke action
to execute/invoke the action you can use below

$ bx wsk action invoke --result openWhiskTester --param <inputParam> <value of that arg> --blocking

##webAction 
or if you create the webAction end point for it using <code>--web true</code>
then you can call the end point directly and passing the number parameters as GET method input
using below url
https://openwhisk.ng.bluemix.net/api/v1/web/navidh2%40uw.edu_dev/default/openWhiskTester.json?number=30
for example I passed number = 30 with GET method and receieved below result


result	"input_number,start_time, stop_time, interval_nanoSec,\n30, 2897973813303496, 2897973821313549, 8010053, "
