def call(body) {

    //def branch = env.BRANCH_NAME 
    def ymlObj

    pipeline {
        agent any
        stages {
            
            stage('init') {
                steps {
                    git branch: "yaml", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                    
                    //ymlObj = readYaml file: "${WORKSPACE}/yaml-families/family.yaml"
                    ymlObj = readYaml(file: "${WORKSPACE}/yaml-families/family.yaml")
                    //echo "${ymlObj}"
                    //echo "${ymlObj.getClass()}"
                }
            }
            /*
            stage('readYaml') {
                steps {
                    //ymlObj = readYaml(file: "yaml-families/family.yaml")
                    //echo "${WORKSPACE}" // /var/jenkins_home/workspace/aqms-desafio2
                    ymlObj = readYaml file: "yaml-families/family.yaml"
                    echo "${ymlObj}"
                    echo "${ymlObj.getClass()}"

                }
            }                 
           */             
        }
    }
}

