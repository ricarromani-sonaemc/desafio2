def call(body) {

    //def branch = env.BRANCH_NAME 

    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                    sh 'printenv'
                    echo "${env.BRANCH_NAME}"
                    /*
                    switch(env.BRANCH_NAME) {
                        case 'yaml':
                            ymlObj = readYaml file: "yaml-families/family.yaml" 
                            echo "${ymlObj}"
                            echo "${ymlObj.getClass()}"
                            break

                        default:
                        error('Unexpected branch name')
                    }
                    */
                }
            }
        }
    }
}
