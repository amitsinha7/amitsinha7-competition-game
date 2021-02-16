import axios from 'axios'
import { API_URL } from '../../Constants'

class CompetitionGameService {
    retrieveAllTasks() {
        return axios.get(`${API_URL}/getAllChallengeIds`);
    }

}

export default new CompetitionGameService()
