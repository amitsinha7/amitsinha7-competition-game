import axios from 'axios'
import { API_URL_JWT , API_URL} from '../Constants'

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

class ChallengeAPI {

    executeJwtChallengeAPI(username, password) {
        return axios.post(`${API_URL_JWT}/authenticate`, {
            username,
            password
        })
    }

    retrieveAllTasks() {
        return axios.get(`${API_URL}/getAllChallengeIds`);
      }
    
      executeSubmitChallenge(name, description, challengeType, sourceCode,) {
        return axios.post(`${API_URL}/submitChallenges`, {
          name,
          description,
          challengeType,
          sourceCode,
        });
      }

    registerSuccessfulLoginForJwt(username, token) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username)
        this.setupAxiosInterceptors(this.createJWTToken(token))
    }

    createJWTToken(token) {
        return 'Bearer ' + token
    }

    logout() {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (user === null) return false
        return true
    }

    getLoggedInUserName() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (user === null) return ''
        return user
    }

    setupAxiosInterceptors(token) {

        axios.interceptors.request.use(
            (config) => {
                if (this.isUserLoggedIn()) {
                    config.headers.authorization = token
                }
                return config
            }
        )
    }
}

export default new ChallengeAPI()