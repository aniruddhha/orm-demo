package com.ani.orm.mapping;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public MappingService(
            BoardRepository boardRepository,
            ProcessorRepository processorRepository
    ) {
        this.boardRepository = boardRepository;
        this.processorRepository = processorRepository;
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
}
