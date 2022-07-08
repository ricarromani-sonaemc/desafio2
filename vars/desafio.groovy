import pipeline.Families
import pipeline.Family
import pipeline.Member




def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj

    //def member2 = new Member()

    pipeline {
        agent any
        stages {
            
            stage('init') {
                steps {          
                    script {
                        git branch: "yaml", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                        
                        //sh "ls ${WORKSPACE}"
                        yamlObj = readYaml file: "${WORKSPACE}/yaml-families/family.yaml"
                        //yamlObj = readYaml file: "resources/member.yaml"
                        echo "${yamlObj}" 
                               
                    }   
                }
            }
            
            stage('convert yaml to object') {
                steps {
                    script {
                        String newarray =[]
                        flag =0;
                        
                       //mapper = new ObjectMapper(new YAMLFactory());
                        //mapper.findAndRegisterModules();/*
                        //Member member = mapper.readValue(new File("resources/member.yaml"), Member.class);
                        
                        Families families = new Families()                        
                        
                        echo "numero de familias = ${yamlObj.families.size()}"
                        for (int i = 0; i < yamlObj.families.size(); i++) {

                            Family family = new Family()
                            family.name = yamlObj.families[i].family[0].name
                            families.family.add(family)

                            echo "A familia ${yamlObj.families[i].family[0].name} é constituida por ${yamlObj.families[i].family[0].members.size()} membros."
                           // String  n = yamlObj.families[i].family[0].members[0].lastName       
                            for(int f = 0; f < yamlObj.families[i].family[0].members.size(); f++) {
                                
                                //newarray[flag]= "yamlObj.families[i].family[0].members[f]";
                                flag++;
                                
                                echo "${yamlObj.families[i].family[0].members[f]}"
                                echo "${families}"
                                /*
                                Member member = new Member()
                                member.firstName = yamlObj.families[i].family[0].members[f].firstName
                                member.lastName = yamlObj.families[i].family[0].members[f].lastName
                                member.job = yamlObj.families[i].family[0].members[f].job
                                member.age = yamlObj.families[i].family[0].members[f].age

                                echo "${member}"
                                
                                families[i].family[0].members.add(member)
                                */
                                
                                
                            }
                        }
                        for( int n =0, n < flag ; n++)
                        //     echo "${newarray[n]}"


                    
                        //echo "${member.ToString()}"
                        //echo "${member.firstName}"
                        //echo "${member.lastName}"
                        //echo "${member.job}"

                    }
                }
            }
            
        }
    }         
}
