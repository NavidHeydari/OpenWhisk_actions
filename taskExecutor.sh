#! /bin/sh

module load parallel

echo "starting"

for ((count=1;count < 200 ;count++))
{
	#curl https://openwhisk.ng.bluemix.net/api/v1/web/navidh2%40uw.edu_dev/default/openWhiskTester.json?number=20 | grep result > cpuStress_res${count}.csv

curl https://openwhisk.ng.bluemix.net/api/v1/web/navidh2%40uw.edu_dev/default/openWhiskTester.json?number=20 | grep result >> cpuStress_res.csv

}
echo "finished"
exit 0
