pipeline {
    
	agent any

    tools {
        maven "maven-3.8.7"
    }

    stages {
        stage('build') {
            steps {
               
                    
                        
                        sh "mvn clean install"
                        sh 'docker build -t student-service .'
                    
                }
            }
        
       
        stage('run'){
            steps {
               sh 'docker run -d -p 9080:9080 --name app-order-service student-service'
            }
        }
		             
                
    }
    
}
       
       
    
  
