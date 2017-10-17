node {
   stage('Preparation') { 
      git 'https://github.com/zmora-agh/zmora-ui.git'
   }
   stage('Build') {
      tools {nodejs "default"}
	  steps {
	    sh 'npm --version'
	  }
   }
}
