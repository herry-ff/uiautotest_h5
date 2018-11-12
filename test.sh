#! /bin/bash
appName=d2p_wechat
version=1.0.1-SNAPSHOT

echo "run 已经打包好的package"
program_dir=/Users/Shared/Jenkins/Home/workspace/d2p_wechat_ui_test
test_time=`date +'%Y%m%d%H%M%S'`
test_output_dir="${program_dir}/test-output/"
mkdir -p $test_output_dir
test_out_html=custom-test-report.html
#java -jar ${program_dir}/target/${appName}-${version}.jar
java -jar ${program_dir}/target/${appName}-${version}.jar ${test_output_dir} > ${test_output_dir}/${test_time}.html
echo "测试完毕"
#
#cd $program_dir/test-output/
#mv $test_out_html report-$test_time.html
