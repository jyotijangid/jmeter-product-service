pipeline {
    agent any 
	stages {
	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
			bat label: 'Compilation running', script: '''mvn compile'''
	       	}
	}
	
	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
			bat label: 'Test running', script: '''mvn test'''
	       
       		}
   	}

	stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
		}
	}
        
	stage('Jmeter Tests'){
		steps{
			echo 'Project performance testing stage'
			bat label: 'Project packaging', script: '''cd C:/apache-jmeter-5.2.1/bin
								   jmeter -jjmeter.save.saveservice.output_format=csv -n -t C:/apache-jmeter-5.2.1/bin/Producttestplan1.jmx -l C:/apache-jmeter-5.2.1/bin/jmeter-html-reports/ProductReportJenkins1.csv -q C:/apache-jmeter-5.2.1/bin/user.properties -e -o C:/apache-jmeter-5.2.1/bin/jmeter-html-reports/html-product-reportJenkins1'''
		}
	} 	
	    
	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
			bat label: 'Project packaging', script: '''mvn package'''
		}
	} 	
    }
}
