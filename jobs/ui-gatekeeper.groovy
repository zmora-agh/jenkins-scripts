pipeline {
		agent any
		tools {nodejs "default"}
		stages {
				stage('Preparation') {
						steps {
								git 'https://github.com/zmora-agh/zmora-ui.git'
						}
				}
				stage('Install') {
						steps {
								sh 'npm install'
						}
				}
				stage('Build') {
						steps {
								sh 'npm run build'
						}
				}
				stage('Lint') {
						steps {
								sh 'npm run lint'
						}
				}
		}
}
