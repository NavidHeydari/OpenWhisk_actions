#! /bin/sh

echo "starting"
#cmd = "bx wsk action invoke --result openWhiskTester --param number 5 --blocking"
curl -X POST https://openwhisk.ng.bluemix.net/api/v1/namespaces/navidh2%40uw.edu_dev/actions/openWhiskTester?blocking=true&number=3
cmd2 = "echo sample"

for ((count=1;count < 10;count++))
{
	#$cmd >
	$cmd2 > sample1234.txt
}
exit 0


#https://openwhisk.ng.bluemix.net/api/v1/web/navidh2%40uw.edu_dev/default/openWhiskTester.json?number=30

