def call(body) {

    //def branch = env.BRANCH_NAME 
    def ymlObj

    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                        git branch: "yaml", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                        
                        ymlObj = readYaml file: "yaml-families/family.yaml" 
                        echo "${ymlObj}"
                        echo "${ymlObj.getClass()}"
                }
            }
        }
    }
}

