pipeline {
	agent any
	tools {nodejs "default"}
	stages {
		stage('Preparation') {
			steps {
				git branch: 'develop', url: 'https://github.com/zmora-agh/zmora-server-rails.git'
				sh 'git clean -fdx'
			}
		}
		stage('Install') {
			steps {
				sh './bin/bundle install'
			}
		}
		stage('Lint') {
			steps {
				sh './bin/bundle exec rubocop --require rubocop/formatter/checkstyle_formatter --format RuboCop::Formatter::CheckstyleFormatter -o reports/xml/checkstyle-result.xml'
				checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'reports/xml/checkstyle-result.xml', unHealthy: ''
			}
		}
	}
}
