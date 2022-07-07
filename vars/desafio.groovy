import java.io.*
import java.util.*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import pipeline.Families
import pipeline.Family
import pipeline.Member


def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj
    def yaml = "${WORKSPACE}/yaml-families/family.yaml"

    pipeline {
        agent any
        stages {
            
            stage('init') {
                steps {          
                    script {
                        git branch: "yaml", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                        
                        sh "ls ${WORKSPACE}"
                        yamlObj = readYaml file: ${yaml}
                        echo "${yamlObj}"            
                    }   
                }
            }

            stage('convert yaml to object') {
                steps {
                    script {
                            File file = new File(yaml);    
                            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
                            Families families = objectMapper.readValue(file, Families.class);
                            System.out.println("Application config info " + families.toString());
                    }
                }
            }
        }
    }         
}


