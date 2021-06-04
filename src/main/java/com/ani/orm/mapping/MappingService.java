package com.ani.orm.mapping;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
*  - One To One
*  - One To Many
*  - Many To Many
*  - can be unidirectional or bidirectional
* */

@Service
public class MappingService {

    private final BoardRepository boardRepository;
    private final ProcessorRepository processorRepository;
    private final ChipRepository chipRepository;

    public MappingService(
            BoardRepository boardRepository,
            ProcessorRepository processorRepository,
            ChipRepository chipRepository
    ) {
        this.boardRepository = boardRepository;
        this.processorRepository = processorRepository;
        this.chipRepository = chipRepository;
    }

    public void craftBoard() {
        Board board = new Board();
        board.setMfg("abc");
        board.setMfgDt(LocalDate.now());
        boardRepository.save( board );
    }

    public void craftBoardWithProcessor() {
        Board board = new Board();
        board.setMfg("pqr");
        board.setMfgDt(LocalDate.now());

        Processor processor = new Processor();
        processor.setMake("hhh");
        processor.setType(1);
        processor.setBoard(board);

        board.setProcessor(processor);

        boardRepository.save(board);
    }

    public void craftProcessor() {

        Board board = boardRepository.findById(1L).orElseThrow(RuntimeException::new);

        Processor processor = new Processor();
        processor.setBoard(board);
        processor.setType(2);
        processor.setMake("kkk");

        processorRepository.save(processor);
    }

    public void findAllProcessors() {
        processorRepository.findAll().forEach(System.out::println);
    }

    public void findBoardFromProcessor() {
        // afternoon
    }

    public void craftBoardWithChips() {

        Board board = new Board();
        board.setMfgDt(LocalDate.now());
        board.setMfg("nnn");

        List<Chip> chips = new ArrayList<>();
        Chip chip1 = new Chip();
        chip1.setCompatibility("un");
        chip1.setPrg(true);
        chip1.setBoard(board);
        chips.add(chip1);

        Chip chip2 = new Chip();
        chip2.setCompatibility("na");
        chip2.setPrg(false);
        chip2.setBoard(board);
        chips.add(chip2);

        Chip chip3 = new Chip();
        chip3.setCompatibility("ab");
        chip3.setPrg(true);
        chip3.setBoard(board);
        chips.add(chip3);

        board.setChips(chips);

        boardRepository.save(board);
    }

    public void craftChip() {
        Board board = boardRepository.findById(1L).orElseThrow(RuntimeException::new);

        Chip chip = new Chip();
        chip.setBoard(board);
        chip.setCompatibility("un");
        chip.setPrg(true);

        chipRepository.save(chip);
    }

    @Transactional
    public void findAllChipsOnTheBoard() {
        //tx.begin()
        Board board = boardRepository.findById(1L).orElseThrow(RuntimeException::new);
        board.getChips().forEach(System.out::println);
        //tx.commit();
    }
}
