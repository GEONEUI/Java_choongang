 public TicketOneWay() {
        String[] title = {"출발시간","회사","등급","잔여석","요금"}; // 컬럼 네임 설정
        String[][] row = new String[0][5];                    // 표들
        model = new DefaultTableModel(row,title);   // 열 이름 추가, 행은 0개 지정

        table = new JTable(model);   // 표 테이블 생성
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // 하나의 행만 선택 가능

        scroll = new JScrollPane(table);  // 스크롤 팬 추가
        scroll.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));   //너무 붙어있어서 가장자리 띄움(padding)
        add("North", scroll);

        setVisible(true);
    }

    // 표 테이블에 데이터 추가
    public void showTicket(Ticket t, String start, String end, String date) {
        // 지워 지워
//        for (int i = model.getRowCount()-1; i >= -1; i--) {
//            model.removeRow(i);
//        }

        // 중복 제거
        if (this.start.equals(start) && this.end.equals(end) && this.date.equals(date)) return;

        // 중복 출력을 방지하기 위해 출발 정류장, 도착 정류장 이름 기억
        this.start = start;
        this.end = end;
        this.date = date;

        // 이미 한 번 조회한 적이 있을 경우 테이블 리셋
        if (this.start != "시작") {
            for (int i = len-1; i >= 0; i--) {
                this.model.removeRow(i);
            }
        }

        len = t.starttime.size();
        // 표 테이블에 티켓 정보 삽입
        for (int i = 0; i < len; i++) {
            String[] data = {t.starttime.get(i), t.company.get(i), t.class_.get(i), String.valueOf(t.seats.get(i)), String.valueOf(t.price.get(i))};
            model.addRow(data);
        }

        // 선택한 표에 대한 정보 가져오기
        table.addMouseListener(this);

        setVisible(true);
    }