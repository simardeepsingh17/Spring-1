pipeline {
    


    tools {
        maven "maven_m2"
    }

    stages {
        stage('build') {
            steps {
                script{
                    
                        
                        sh "mvn clean install"
		                sh 'docker image build -t order-service:1 .'
                    
                }
            }
        }
        stage ('Killing Containers') {
            steps {

                echo "====== killing Containers====="
                script {
                    try {
                        sh "docker rm -f app-order-service"
                    }catch(Exception e) {
                        echo e.getMessage()
                        echo "Container not found app-order-service"
                    }
                }
            }
        }
        stage('run'){
            steps {
               sh 'docker run -d -p 9080:9080 --name app-order-service order-service:1'
            }
        }
    }
  
}