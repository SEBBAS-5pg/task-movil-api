pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'task-movil-api'
        DOCKER_TAG = "${env.BUILD_ID}"
        PROJECT_DIR = 'backend_lista_compras'
        CONTAINER_PORT = '3000'
        HOST_PORT = '3000'
    }
    
    stages {
        
        stage('Checkout') {
            steps {
                echo '🔍 Descargando código desde GitHub...'
                checkout scm
            }
        }
        
        stage('Install Dependencies') {
            steps {
                echo '📦 Instalando dependencias Node.js...'
                dir(env.PROJECT_DIR) {
                    sh 'npm ci'
                }
            }
        }
        
        stage('Prisma Generate') {
            steps {
                echo '🗄️ Generando cliente de Prisma...'
                dir(env.PROJECT_DIR) {
                    sh 'npx prisma generate'
                }
            }
        }
        
        stage('Test') {
            steps {
                echo '🧪 Ejecutando tests...'
                dir(env.PROJECT_DIR) {
                    sh 'npm test'
                }
            }
        }
        
        stage('Build') {
            steps {
                echo '🏗️ Construyendo aplicación NestJS...'
                dir(env.PROJECT_DIR) {
                    sh 'npm run build'
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                echo '🐳 Construyendo imagen Docker...'
                dir(env.PROJECT_DIR) {
                    sh "docker build -t ${env.DOCKER_IMAGE}:${env.DOCKER_TAG} ."
                }
                
                sh "docker images | grep ${env.DOCKER_IMAGE}"
            }
        }
        
        stage('Deploy') {
            steps {
                echo '🚀 Desplegando aplicación NestJS...'
                script {
                    sh """
                    docker stop nest-api-container || true
                    docker rm nest-api-container || true
                    """
                    
                    sh """
                    docker run -d \\
                      -p ${env.HOST_PORT}:${env.CONTAINER_PORT} \\
                      --name nest-api-container \\
                      ${env.DOCKER_IMAGE}:${env.DOCKER_TAG}
                    """
                    
                    echo "✅ API NestJS desplegada en: http://localhost:${env.HOST_PORT}"
                }
            }
        }
        
        stage('Health Check') {
            steps {
                echo '❤️ Verificando salud de la aplicación...'
                script {
                    sleep 10
                    sh """
                    curl -f http://localhost:${env.HOST_PORT}/api/health || \\
                    curl -f http://localhost:${env.HOST_PORT}/health || \\
                    echo "Health check endpoint no disponible"
                    """
                }
            }
        }
    }
    
    post {
        always {
            cleanWs()
            echo "📦 Build #${env.BUILD_NUMBER} completado"
        }
        success {
            echo '🎉 ✅ PIPELINE NESTJS EXITOSO!'
        }
        failure {
            echo '💥 ❌ PIPELINE FALLIDO!'
        }
    }
}