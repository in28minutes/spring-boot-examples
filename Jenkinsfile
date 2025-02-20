pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "your-dockerhub-username/spring-boot-app"
        DOCKER_TAG = "latest"
        AWS_REGION = "us-east-1"
        ECS_CLUSTER = "your-ecs-cluster"
        ECS_SERVICE = "your-ecs-service"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/in28minutes/spring-boot-examples.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                    sh "echo ${env.DOCKER_HUB_PASSWORD} | docker login -u ${env.DOCKER_HUB_USERNAME} --password-stdin"
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('Deploy to ECS') {
            steps {
                script {
                    sh """
                    aws ecs update-service --cluster ${ECS_CLUSTER} --service ${ECS_SERVICE} --force-new-deployment --region ${AWS_REGION}
                    """
                }
            }
        }
    }
  
