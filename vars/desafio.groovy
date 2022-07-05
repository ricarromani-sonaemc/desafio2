def call(body) {

    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                    switch(env.BRANCH_NAME) {
                        case 'yaml':
                            ymlObj = readYaml file: "yaml-families/family.yaml" 
                            echo "${ymlObj}"
                            echo "${ymlObj.getClass()}"
                            break
                            
                        default:
                        error('Unexpected branch name')
                    }
                }
            }
        }
    }
}
