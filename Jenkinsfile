pipeline{
    
    agent any
    
    environment{
        DOCKER_TAG = getVersion()
        
    }
    
    
    stages{
        stage('SCM'){
            steps{
                git credentialsId: 'github', 
                url: 'https://github.com/ayb112/dockeransiblejenkins'
                
            }
        }

    
        stage('Maven Build'){
            steps{
                sh "mvn clean package"
            }
            
        }
        
        stage('Docker Build'){
            steps{
                echo "DOCKER_TAG engine is ${DOCKER_TAG}"
                sh "docker build . -t ayb112/aaa:${DOCKER_TAG} "
            }
            
        }     
        
        stage('Docker Push'){
            steps{
                withCredentials([string(credentialsId: 'docker-hub-ayb', variable: 'dockerHubPwd')]) {
                  sh "docker login -u ayb112 -p ${dockerHubPwd} "
                }
                
                sh "docker push ayb112/aaa:${DOCKER_TAG} "
            }
            
        }        
    
    }
    
}

    def getVersion (){
         def commitHash = sh label: '', returnStdout: true, script: 'git rev-parse --short HEAD'
         return commitHash
    }
