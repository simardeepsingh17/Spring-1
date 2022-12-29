pipeline {
    
	agent any

    tools {
        maven "maven_m2"
    }

    stages {
        stage('build') {
            steps {
               
                    
                        
                        sh "mvn clean install"
		             
                
            }
        }
       
       
    }
  
}