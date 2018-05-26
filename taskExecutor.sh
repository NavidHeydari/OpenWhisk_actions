#! /bin/sh

echo "starting"
cmd = "bx wsk action invoke --result openWhiskTester --param number 5 --blocking"
cmd2 = "echo sample"

for ((count=1;count < 10;count++))
{
	#$cmd >
	$cmd2 > sample1234.txt
}
exit 0


#https://service.us.apiconnect.ibmcloud.com/gws/apigateway/api/9fadac666d0130cfa988c53d4f7920d7b3c72c7f5a942b25e3b8c250862cd1c1/5f1bc93f-5d4b-439a-9bce-9f025ac570f8