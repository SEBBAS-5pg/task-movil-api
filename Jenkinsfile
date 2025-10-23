pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'task-movil-api'
        DOCKER_TAG = "${env.BUILD_ID}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Docker Build & Deploy') {
            steps {
                dir('backend_lista_compras') {
                    sh "docker build -t ${env.DOCKER_IMAGE}:${env.DOCKER_TAG} ."
                }
                sh """
                docker stop nest-api-container || true
                docker rm nest-api-container || true
                docker run -d -p 3000:3000 --name nest-api-container ${env.DOCKER_IMAGE}:${env.DOCKER_TAG}
                """
                echo "✅ API NestJS desplegada en: http://localhost:3000"
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
        success {
            echo '🎉 ✅ PIPELINE EXITOSO!'
        }
        failure {
            echo '💥 ❌ PIPELINE FALLIDO!'
        }
    }
}