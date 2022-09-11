package ifmo.ru.CourceWorkBackEnd.service;

import ifmo.ru.CourceWorkBackEnd.model.Human;
import ifmo.ru.CourceWorkBackEnd.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanService {
    private HumanRepository humanRepository;

    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public void saveHuman(Human human) {
        humanRepository.save(human);
    }

    public Human getById(int id) {
        return humanRepository.getOne(id);
    }

    public Human getByNumber(String number) {
        return humanRepository.findbyPhone(number);
    }
}
